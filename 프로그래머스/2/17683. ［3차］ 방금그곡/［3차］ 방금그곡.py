def solution(m, musicinfos):
    answer = ''
    #처음부터 재생
    # #처리 안함!!!! 대체하기
    m = m.replace("C#","c").replace("D#","d").replace("F#","f").replace("G#","g").replace("A#","a").replace("E#","e")
    #음악 없을 땐 "(None)"
    #m: 기억한 멜로디
    #musicinfos[i] = "시작시각,끝난시각,음악제목,악보정보,재생시간"
    music_line = [] #재생된 멜로디 저장
    name = []
    music_sp = []
    for idx,music in enumerate(musicinfos):
        line = ""
        music_sp.append(music.split(","))
        start = list(map(int, music_sp[idx][0].split(":")))
        end = list(map(int, music_sp[idx][1].split(":")))
        time = (end[0] * 60 + end[1]) - (start[0] * 60 + start[1])
        #아 미친 먼저 입력됐다는게 진짜 배열 인덱스 순서임? 이거면 진자 아 개오반데
        # print(time)
        music_sp[idx].append(time)
        music_sp[idx].append(idx)
        music_sp[idx][3] = music_sp[idx][3].replace("C#","c").replace("D#","d").replace("F#","f").replace("G#","g").replace("A#","a").replace("E#","e")
        t = time // len(music_sp[idx][3])
        r = time % len(music_sp[idx][3])
        line = (music_sp[idx][3] * t) + music_sp[idx][3][:r]
        music_line.append(line)
    # print(music_line)
    #일치 음악 찾기
    print(music_sp)
    #찾은 노래 인덱스 저장
    #m이 들은 멜로디 시간이 한곡보다 짧을 경우 -> 길이만큼만 찾아야함
    find = []
    for i in range(len(music_line)):
        if m in music_line[i]:
            find.append(music_sp[i])
    #적합한 노래 찾기
    #재생된 시간이 제일 긴 음악 제목 반환
    #같을 경우 먼저 입력된 음악 제목 반환
    if not find:
        return "(None)"
    elif len(find) == 1:
        return find[0][2]
    else:
        return find_long(find)
    
    
#끝난시각 - 시작시각 -> 악보정보 다시 생성
def find_long(find):
    sorted_music = sorted(find, key = lambda x:(-x[4],x[5]))
    # print(sorted_music)
    return sorted_music[0][2]
    