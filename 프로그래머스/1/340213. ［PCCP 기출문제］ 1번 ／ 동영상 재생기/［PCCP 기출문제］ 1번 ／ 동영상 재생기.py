"""
prev: 10초 전
next : 10초 후
오프닝 건뛰 : 오프닝이 끝나는 위치 op_end

사용자 입력이 모두 끝난 후 동영상의 위치 mm:ss 형식

"""
def solution(video_len, pos, op_start, op_end, commands):
    video = list(map(int,video_len.split(":")))
    pos = list(map(int,pos.split(":")))
    op_start = list(map(int,op_start.split(":")))
    op_end = list(map(int,op_end.split(":")))
    
    def next_instruction():
        #10초 후로 이동
        #남은 시간이 10초 미만일경우 마지막 위치 = 동영상 길이
        if pos[0] == video[0] and video[1] - pos[1] < 10:
            pos[1] = video[1]
        else:
            pos[1] += 10
            if pos[1] >= 60:
                pos[0] += 1
                pos[1] -= 60
            #영상이 끝나는 경우 예외처리
            if pos[0] * 60 + pos[1] > video[0] * 60 + video[1]:
                pos[0],pos[1] = video[0],video[1]
    def prev_instruction():
        #10초 전으로

        #현재 위치 10초 미만 -> 처음 이동 00:00
        if pos[0] == 0 and pos[1] < 10:
            pos[1] = 0
        else:
            pos[1] -= 10
            if pos[1] < 0:
                pos[0] -= 1
                pos[1] += 60
    def op_jump_instruction():
        #현재 위치 확인
        op_st_sec = op_start[0] * 60 + op_start[1]
        op_end_sec = op_end[0] * 60 + op_end[1]
            
        if op_st_sec <= pos[0] * 60 + pos[1] <= op_end_sec:
            pos[0] = op_end[0]
            pos[1] = op_end[1]
    
    for com in commands:
        op_jump_instruction()
        if com == "next":
            next_instruction()
        elif com == "prev":
            prev_instruction()
        op_jump_instruction()
    return make_format(pos)

def make_format(pos):
    return f"{pos[0]:02d}:{pos[1]:02d}"