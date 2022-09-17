$(function () {
	let url = "http://localhost:1124/back/lesson/";
	$.ajax({
		url: url,
		method: "get",
		success: function (jsonObj) {
			//card
			// header div#normal
			// $sidebarObj = $("div#sidebar");
			// var arr = [];
			// let sido = "<ul>";
			// $(jsonObj.sido).each(function (key, item) {
			// 	// console.log(Object.values(item));
			// 	$keyObj = Object.keys(item);
			// 	$itemObj = Object.values(item);
			// 	for (let i = 0; i < $itemObj.length; i++) {
			// 		arr.push($itemObj[i]);
			// 		console.log($keyObj);
			// 		sido += '<li class="sido" name="sido" value="' + $keyObj[i] + '"';
			// 		sido += ">" + $itemObj[i] + "</li>";
			// 	}
			// });
			// sido += "</ul>";
			// $sidebarObj.append(sido);

			$lsnObj = $("div.col");
			// $lsnObj = $('<div class="col">');
			// $('div#card-container').append($lsnObj);
			$(jsonObj.t).each(function (index, item) {
				console.log(item.userInfo.userName + "  " + item.locNo);
				console.log(item.userInfo.userId);
				let product = '<div class="lsn" id=' + item.lsnNo + ">";
				product +=
					'<img src= "../lsn_images/' +
					item.lsnNo +
					'_LessonThumbnail.jpg" alt="lsnimg"/>'; // 각레슨의 이미지경로 다시 설정해야함 c밑의 경로임
				// '<div id="lsnImg"><img src="../user_images/' +
				// item.user.userID +
				// '/LessonThumbnail.jpg"/></div>'; // 각레슨의 이미지경로 다시 설정해야함 c밑의 경로임

				product += '<div class="lsn_content">';
				product += '<h5 class="lsn_title">' + item.lsnTitle + "</h5>";
				product +=
					'<p class="pro_name">프로이름 : ' + item.userInfo.userName + "</p>";
				// product +='<p class="tag_name">태그이름 : ' + item.locNo + '</p>';// 지역번호/
				product +=
					'<p class="star_point">별점  : ' + item.lsnStarScore + "</p></div>";
				product += "</div>";
				// console.log(product);
				let $copyObj = $lsnObj.clone(); //복제본 생성
				$copyObj.html(product);
				$("div#card-container").append($copyObj);
			});
			$lsnObj.hide(); // 복제본이 아닌 td태그를 숨김

			return false;
		},
		error: function (jqXHR) {
			alert("error: " + jqXHR.status);
		},
	});

	$.ajax({
		url: "http://localhost:1124/back/user/loginstatus",
		method:"get",
		success: function (jsonObj) {
			let $tabObj = $("div#content>div#content-right");
			let $tabObjHtml = "";
			if (jsonObj.status == 1) {
				// $('header div#logined').show();
				$tabObjHtml +=
					'<div id="logined"><div id="logout" onclick="logout()">로그아웃</div>';
				if (jsonObj.type == 1) {
					$tabObjHtml +=
						'<div id="addlsn"><a id="mypage" href="/front/html/addlesson.html">레슨등록</a></div>';
				}
				$tabObjHtml +=
					'<div id="mypage" onclick="mypage()">마이페이지</div></div>';
			} else {
				// $('header div#normal').show();
				$tabObjHtml +=
					' <div id="normal"><a href="/front/html/login.html">로그인</a>';
				$tabObjHtml +=
					'<a href="/front/html/signuptype.html">회원가입</a></div>';
			}
			$tabObj.html($tabObjHtml);

			// return false;
		},
		error: function (jqXHR) {
			alert(jqXHR.status);
		},
	});

	$("div#card-container").on("click", "div.col>div.lsn", function (e) {
		// 클릭한 lsn_no
		$lsnId = $(this).attr("id");
		console.log($lsnId);
		location.href = "/front/html/viewlesson.html?lsn_no=" + $lsnId;
	});
});
