$(document).ready(()=>{
$("#join").on('click', joinroom)
})
var joinroom = (e) => {
    e.preventDefault()
var name = $("#uname").val()
var room = $("#room").val()

$.ajax({
            type: "POST",
            url: "/join-room",
            data: JSON.stringify({
            "name": name,
            "room": room
            }),
            success: function(res){
                window.localStorage.setItem("name", res.name)
                window.localStorage.setItem("room", res.room)
                window.location.pathname = "chat.html"
            },
            error: function (xhr, ajaxOptions, thrownError) {
                console.log(xhr, ajaxOptions, thrownError)
            },
            dataType: "json",
            contentType : "application/json"
        });
}