■起動手順

１．実機側でecrobot_init_bt_slave()をひたすら回しておく。
２．このツールを起動
３．しばらく待つと、実機側でecrobot_get_bt_status()==BT_STREAMとなるので、その後からecrobot_send_bt()などでやり取りできるようになる。