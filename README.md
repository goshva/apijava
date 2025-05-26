# Spring boot Java 

### 1. GET /api/messages - Получить все сообщения
```bash
curl -X GET https://vezit.ru/api/messages \
-H "Accept: application/json" \
--insecure
```

### 2. POST /api/messages - Создать новое сообщение
```bash
curl -X POST https://vezit.ru/api/messages \
-H "Content-Type: application/json" \
-H "Accept: application/json" \
-d '{"text": "Тестовое сообщение"}' \
--insecure
```

### 3. GET /api/messages/1 - Получить сообщение с ID=1
```bash
curl -X GET https://vezit.ru/api/messages/1 \
-H "Accept: application/json" \
--insecure
```

### 4. PUT /api/messages/1 - Обновить сообщение с ID=1
```bash
curl -X PUT https://vezit.ru/api/messages/1 \
-H "Content-Type: application/json" \
-H "Accept: application/json" \
-d '{"text": "Обновленный текст"}' \
--insecure
```

### 5. DELETE /api/messages/1 - Удалить сообщение с ID=1
```bash
curl -X DELETE https://vezit.ru/api/messages/1 \
-H "Accept: application/json" \
--insecure
```

### Важные примечания:

1. Флаг `--insecure` используется потому что:
   - У вас скорее всего самоподписанный сертификат
   - Или SSL/TLS настроен неправильно
   - В production его нужно убрать!

2. Для production с правильным SSL:
```bash
# Без --insecure, с проверкой сертификата
curl -X GET https://vezit.ru/api/messages \
-H "Accept: application/json"
```

3. Если нужно передавать авторизацию:
```bash
curl -X GET https://vezit.ru/api/messages \
-H "Accept: application/json" \
-H "Authorization: Bearer ваш_токен" \
--insecure
```

4. Для более читаемого вывода можно добавить:
```bash
curl ... | python3 -m json.tool  # или jq
```

5. Для отладки добавьте `-v` для подробного вывода:
```bash
curl -v -X GET https://vezit.ru/api/messages --insecure
```
