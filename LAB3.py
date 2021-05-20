# -*- coding: utf8 -*-
#Кнута-морриса-прата
lil = "лилила"

p = [0]*len(lil)
j = 0
i = 1

while i < len(lil):
    if lil[j] == lil[i]:
        p[i] = j+1
        i += 1
        j += 1
    else:
        if j == 0:
            p[i] = 0;
            i += 1
        else:
            j = p[j-1]
print(p)

st = "лилилось лилилась"
lent = len(lil)
lenst = len(st)

i = 0
j = 0
while i < lenst:
    if st[i] == lil[j]:
        i += 1
        j += 1
        if j == lent:
            print("образ найден")
            break
    else:
        if j > 0:
            j = p[j-1]
        else:
            i += 1

if i == lenst:
    print("образ не найден")


#Урощенный Бойера-Мура
data = "данные"

# Этап 1: формирование таблицы смещений

S = set() # уникальные символы в образе
M = len(data) # число символов в образе
d = {} # словарь смещений

for i in range(M-2, -1, -1): # итерации с предпоследнего символа
    if data[i] not in S: # если символ еще не добавлен в таблицу
        d[data[i]] = M-i-1
        S.add(data[i])

if data[M-1] not in S: # отдельно формируем последний символ
    d[data[M-1]] = M

d['*'] = M              # смещения для прочих символов

print(d)

# Этап 2: поиск образа в строке

weather = "метеоданные"
N = len(weather)

if N >= M:
    i = M-1       # счетчик проверяемого символа в строке

    while(i < N):
        k = 0
        j = 0
        for j in range(M-1, -1, -1):
            if weather[i-k] != data[j]:
                if j == M-1:
                    off = d[weather[i]] if d.get(weather[i], False) else d['*']  # смещение, если не равен последний символ образа
                else:
                    off = d[data[j]]   # смещение, если не равен не последний символ образа

                i += off    # смещение счетчика строки
                break

            k += 1          # смещение для сравниваемого символа в строке

        if j == 0:          # если дошли до начала образа, значит, все его символы совпали
            print(f"образ найден по индексу {i-k+1}")
            break
    else:
        print("образ не найден")
else:
    print("образ не найден")