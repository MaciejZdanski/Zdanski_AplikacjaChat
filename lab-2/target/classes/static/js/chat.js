$(document).ready(()=>{
get_message()
setInterval(get_message,5000)
$("#sent").on('click', sent_message)
})
var get_message = () => {
$.ajax({
                type: "POST",
                url: "/get-room-data",
                data: JSON.stringify({
                "room": window.localStorage.getItem("room")
                }),
                success: function(res){
                    $(".message").empty()
                    for (var i = res.length-1; i > -1; i--) {
                        var arr = res[i].split(";")
                        var uname = arr[1]
                        var time = arr[3]
                        var ms = arr[2]
                        $(".message").append(`<div class="dyflex ms"><div class="uname">${uname}<div class="data">${time}</div></div><div class="messages">${ms}</div></div>`)
                    }
                    var element = $(".message").animate({ scrollTop:"1000000px" });
                },
                error: function (xhr, ajaxOptions, thrownError) {
                    console.log(xhr, ajaxOptions, thrownError)
                },
                dataType: "json",
                contentType : "application/json"
            });
}
var sent_message = () => {
$.ajax({
                type: "POST",
                url: "/sent-message",
                data: JSON.stringify({
                "room": window.localStorage.getItem("room"),
                "username": window.localStorage.getItem("name"),
                "message": $("#mess").val()
                }),
                success: function(res){

                },
                error: function (xhr, ajaxOptions, thrownError) {
                    console.log(xhr, ajaxOptions, thrownError)
                },
                dataType: "json",
                contentType : "application/json"
            });
}