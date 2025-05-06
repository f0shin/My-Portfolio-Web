document.addEventListener("DOMContentLoaded", function() {
    console.log("LAYOUT.JS 파일이 정상적으로 로드됨!");
});

// 메뉴 활성화 및 아이콘 추가
document.addEventListener("DOMContentLoaded", function () {
    let menu = document.querySelectorAll(".menu a");
    let currentPath = window.location.pathname; // 현재 브라우저 URL 경로 가져오기

    console.log("현재 경로:", currentPath); // 디버깅용 로그

    menu.forEach(item => {
        // 기존 `active` 클래스 제거
        item.classList.remove("active");

        // 현재 URL이 메뉴의 href 끝 부분과 일치하면 `active` 클래스 추가
        if (item.href.endsWith(currentPath)) {
            item.classList.add("active");

            // 기존 아이콘 삭제 후 새 아이콘 추가
            let existingIcon = item.querySelector("span");
            if (existingIcon) {
                existingIcon.remove();
            }

            let icon = document.createElement("span");
            icon.textContent = " 🚩";
            item.appendChild(icon);
        }
    });

    // `localStorage`에 현재 활성화된 메뉴 저장
    localStorage.setItem("activeMenu", currentPath);
});

// 메뉴 클릭 시 `localStorage`에 현재 메뉴 저장
document.addEventListener("DOMContentLoaded", function () {
    let menu = document.querySelectorAll(".menu a");
    let activeMenu = localStorage.getItem("activeMenu") || window.location.pathname; // 기본값 설정

    menu.forEach(item => {
        if (item.href.endsWith(activeMenu)) {
            item.classList.add("active");
        }
    });
});

// 언어 선택 및 아이콘 추가
document.addEventListener("DOMContentLoaded", function () {
    let lang = document.querySelectorAll(".lang a");
    let currentLang = localStorage.getItem("currentLang") || "ja_JP";

    lang.forEach(item => {
        if (item.href.endsWith(currentLang)) {
            item.classList.add("active");

            let icon = document.createElement("span");
            icon.textContent = " 🌏";
            item.appendChild(icon);
        }
    });

    lang.forEach(item => {
        item.addEventListener("click", function () {
            // 기존 `active` 클래스 제거
            lang.forEach(el => el.classList.remove("active"));

            // 현재 클릭한 항목에 `active` 클래스 추가
            item.classList.add("active");

            // 기존 아이콘 삭제 후 새 아이콘 추가
            lang.forEach(el => {
                let existingIcon = el.querySelector("span");
                if (existingIcon) {
                    el.removeChild(existingIcon);
                }
            });

            let icon = document.createElement("span");
            icon.textContent = " 🌏";
            item.appendChild(icon);

            // 현재 클릭한 메뉴를 `localStorage`에 저장 (href에서 언어 코드 추출)
            const langCode = item.href.split("=")[1]; // URL에서 마지막 부분 추출
            localStorage.setItem("currentLang", langCode);
        });
    });
});