let index = {
    init: function(){
        $("#btn-save").on("click", ()=>{
            this.save();
        });
        $("#btn-login").on("click", ()=>{
            this.login();
        });
    },

    save: function(){
        let data = {
            joinId: $("#joinId").val(),
            nickName: $("#nickName").val(),
            password: $("#password").val(),
            email: $("#email").val()
        };

        // ajax 호출 시 기본으로 비동기 호출
        $.ajax({
            type: "POST",
            url: "/api/user",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8", // Body 데이터 타입
            dataType: "json"    // 응답 데이터의 타입
        }).done(function(resp){     // resp 는 UserApiController 에서 리턴해 주는 값
            alert("회원가입 완료");
            location.href = "/";
        }).fail(function(error){
            alert(JSON.stringify(error));
        });   // ajax 통신을 이용해서 위의 파라미터를 json 으로 변경하여 insert 요청

    },

    login: function(){
            let data = {
                joinId: $("#joinId").val(),
                password: $("#password").val()
            };

            $.ajax({
                type: "POST",
                url: "/api/user/login",
                data: JSON.stringify(data),
                contentType: "application/json; charset=utf-8",
                dataType: "json"
            }).done(function(resp){
                alert("로그인 완료");
                location.href = "/";
            }).fail(function(error){
                alert(JSON.stringify(error));
            });

        }
}

index.init();
