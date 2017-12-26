<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>문서작성기 SAMPLE</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script language="JavaScript" type="text/JavaScript">
    //hwpctrl를 이용하기 위해서는 한글 2002이상이 사용자 컴퓨터에 깔려 있어야 한다.
    //active X처럼 특별히 웹상에서 설치해야 할 파일은 없다.
    var MinVersion = 0x0505010C;
    var data;
    var pHwpCtrl;
    //페이지 로드시 맨 처음 실행될 함수.
    function OnStart() {
        pHwpCtrl = document.HwpCtrl;
        _VerifyVersion();
        document.HwpCtrl.SetClientName("DEBUG");
        URLOpen();
    }
    function _VerifyVersion() {
        // 설치확인
        if(pHwpCtrl.getAttribute("Version") == null) {
            alert(!"한글 2002 컨트롤이 설치되지 않았습니다.");
            return;
        }
        //버젼 확인
        CurVersion = pHwpCtrl.Version;
        alert(CurVersion.toString(16));
        if(CurVersion < MinVersion) {
            alert(!"HwpCtrl의 버젼이 낮아서 정상적으로 동작하지 않을 수 있습니다.\n"+"최신 버젼으로 업데이트하기를 권장합니다.\n\n"
                  + "현재 버젼: 0x"
                  + CurVersion.toString(16)
                  + "\n"
                  + "권장 버젼: 0x"
                  + MinVersion.toString(16) + " 이상");
        }
    }
    //한글파일 문서 열기
    function URLOpen() {
        var bRes = document.HwpCtrl.RegisterModule("FilePathCheckDLL", "FilePathChecker");
        document.HwpCtrl.Clear(1);               //문서 내용 지움
        document.HwpCtrl.Open("http://stoneis.pe.kr/upload/stone.hwp", "", "code:acp;url:true")
        document.HwpCtrl.EditMode=1;
        document.HwpCtrl.MovePos(2);             //캐럿을 문서 처음으로 이동
    }
    //한글 컨트롤 오브젝트를 html에 심는 함수
    function WriteEmbedHanPop() {
        document.write("<OBJECT id='HwpCtrl' style='LEFT: 0px; TOP: 0px;' height='768' width='1024' align='center' classid='CLSID:BD9C32DE-3155-4691-8972-097D53B10052'>");
        document.write("<PARAM NAME='TOOLBAR_MENU' VALUE='true'>");
        document.write("<PARAM NAME='TOOLBAR_STANDARD' VALUE='true'>");
        document.write("<PARAM NAME='TOOLBAR_FORMAT'   VALUE='true'>");
        document.write("<PARAM NAME='TOOLBAR_DRAW' VALUE='true'>");
        document.write("<PARAM NAME='TOOLBAR_TABLE' VALUE='FALSE'>");
        document.write("<PARAM NAME='TOOLBAR_IMAGE' VALUE='FALSE'>");
        document.write("<PARAM NAME='TOOLBAR_HEADERFOOTER' VALUE='FALSE'>");
        document.write("<PARAM NAME='SHOW_TOOLBAR' VALUE='true'>");
        document.write("</OBJECT>");
    }
</script>
</head>
<body onload="OnStart()">
<input type="button" value="저장" onclick="document.HwpCtrl.SaveAs('C:\\Users\\김연석\\Desktop\\test.hwp', 'HWP', '');" />
<table cellpadding="0" border=0 cellspacing="0" class="fr01">
    <tr>
        <td valign="top">
            <!-- 보고서 뷰어 -->
            <div style="width:1024px;height:768px; overflow-y:scroll;">
            <!-- 한글 파일 미리 보기 보여줄 장소에 오브젝트 엠베디드 하는 스크립트 적용 -->
            <script language="javascript">WriteEmbedHanPop()</script>
        </td>
    </tr>
</table>
</body>
</html>
