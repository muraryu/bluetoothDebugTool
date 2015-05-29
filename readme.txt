■事前準備
PCと実機をペアリングしておく。

■起動手順

１．実機側でecrobot_init_bt_slave()をひたすら回しておく。定期的にecrobot_get_bt_status()を確認し、戻り値がBT_STREAMじゃなかったらecrobot_init_bt_slave()実行みたいなタスクを回すなどしておくと良い。
２．このツールを起動して接続するCOMポートを入力。デバイスのプロパティで確認できる。
３．しばらく待つと、実機側でecrobot_get_bt_status()==BT_STREAMとなるので、その後からecrobot_send_bt()などでやり取りできるようになる。

■ビルド環境
rxtxライブラリを外部jarとしてインクルード
rxtxを落としてきたときに入ってるdllファイル2つをeclipse/jre/libに入れておく。これをしないとライブラリのクラスをロードできない。