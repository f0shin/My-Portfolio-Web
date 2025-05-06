document.addEventListener("DOMContentLoaded", function() {
    console.log("EFFECT.JS 파일이 정상적으로 로드됨!");
});

// 눈 내리기 효과
function createSnowflake() {
    const snowflake = document.createElement("div");
    snowflake.classList.add("snowflake");
    document.querySelector(".snow-container").appendChild(snowflake);
  
    // 랜덤 위치 설정
    snowflake.style.left = `${Math.random() * window.innerWidth}px`;
    snowflake.style.animationDuration = `${Math.random() * 3 + 2}s`;
  
    // 일정 시간 후 삭제
    setTimeout(() => {
      snowflake.remove();
    }, 5000);
}
  
// 일정 간격으로 눈송이 생성
setInterval(createSnowflake, 200);