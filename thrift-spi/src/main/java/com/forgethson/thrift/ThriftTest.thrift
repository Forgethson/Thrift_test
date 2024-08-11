namespace java com.forgethson.java_gen


service UserService {
    User getUserByName(1:required string name)
    bool createUser(1:required User user)
}

struct User {
    1:i32 id
    2:string name
    3:list<string> hobbies
    4:double score
}