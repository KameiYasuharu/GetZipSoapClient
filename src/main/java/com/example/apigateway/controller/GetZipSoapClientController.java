package com.example.apigateway.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.example.apigateway.webservice.GetZipRequest;
import com.example.apigateway.webservice.GetZipResponse;

/**
 * ZIPファイル取得処理を行うRESTコントローラークラス
 * 
 * <p>クライアントからのリクエストを受け付け、ZIPファイル取得サービスを呼び出します。</p>
 */
@RestController // (1) RESTコントローラーとして登録（@Controller + @ResponseBody）
@RequestMapping // ベースURLマッピング
public class GetZipSoapClientController {

	// SOAP通信を行うためのテンプレート
	private final WebServiceTemplate webServiceTemplate;

	/**
	 * コンストラクタ
	 * @param webServiceTemplate Spring WSのWebサービステンプレート
	 */
	public GetZipSoapClientController(WebServiceTemplate webServiceTemplate) {
		this.webServiceTemplate = webServiceTemplate;
	}

	/**
	 * ZIPファイル取得APIエンドポイント
	 * 
	 * <p>GETリクエストで受け取った画像を返します。</p>
	 * 
	 * @param request 変換リクエスト（画像名前を含む）
	 * @return 
	 * @return ZIPファイル取得を含むレスポンス
	 * @throws IOException 
	 */
	@GetMapping("/getZip") // (2) /getPdfパスへのGETリクエストを処理
	@ResponseBody // 戻り値を直接レスポンスボディとして返却
	public GetZipResponse getZipSoapClient() throws IOException {
		return (GetZipResponse) webServiceTemplate.marshalSendAndReceive(new GetZipRequest());

	}
}