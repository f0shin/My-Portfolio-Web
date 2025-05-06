document.addEventListener("DOMContentLoaded", function() {
    console.log("FORM.JS 파일이 정상적으로 로드됨!");
});

// 알림 테스트
document.addEventListener("click", (event) => {
    if (event.target && event.target.id === "init_button") {
        document.getElementById("form").reset();
        toastr.info("Init Success🫧!", "Info");
    }
});