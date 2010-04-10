require sysfsutils.inc

PR = "${INC_PR}"
SRC_URI += "file://get_mnt_path_check.patch;patch=1"

SRC_URI[md5sum] = "14e7dcd0436d2f49aa403f67e1ef7ddc"
SRC_URI[sha256sum] = "e865de2c1f559fff0d3fc936e660c0efaf7afe662064f2fb97ccad1ec28d208a"
