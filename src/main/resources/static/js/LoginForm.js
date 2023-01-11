const signUpBox = document.querySelector(".sign-up-box");	//.sign-up-box 클래스를 signUpBox라고 부르자

signUpBox.addEventListener("click", handleClick, false); // 
function handleClick(event) {
  if (signUpBox.classList.contains("active")) return;	//active클래스 존재여부
  let str = `
        <span onclick="event.stopPropagation(); removedActive();">X</span>
        <input type="text" name="name" placeholder="아이디" id="userid"/>
        <input type="password" name="password" placeholder="Password" id="pwd"/>
        <input type="text" placeholder="닉네임" id='nickname'/>
        <input type="email" name="email" placeholder="Email" id="email"/>
        <input type="email" name="email1" placeholder="Email" id="email1"/>
        <button onclick="event.stopPropagation(); handleSignUp();" >가입완료</button>
    `;						// stopPropagation = 상위 엘리먼트로 이벤트전파 중지
  this.classList.toggle("active"); // 클래스명 스위치
  this.innerHTML = "";
  setTimeout(() => (this.innerHTML = str), 500);
}

function removedActive() {
  signUpBox.classList.remove("active");	// 클래스명 제거
  signUpBox.innerHTML = `<i class="material-icons">+</i>`;
}
function handleSignUp() {
  let signUpBoxActive = document.querySelector(".active");
  let inputs = signUpBoxActive.querySelectorAll("input");
  let nameField = inputs[0];
  let emailField = inputs[1];
  let passwordField = inputs[2];
  if (
    nameField.value === "" ||
    emailField.value === "" ||
    passwordField.value === ""
  ) {
	alert("모든 항목은 필수 입력 입니다");
    return;
  }
  else {
	//var userid = document.getElementById("userid").value; html에서 userid
	alert(userdata);
}
  removedActive();
}

// loginbtn.addEventListener("click", function(event){alert('Hello');});