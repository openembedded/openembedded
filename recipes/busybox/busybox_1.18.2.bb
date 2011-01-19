require busybox_1.1x.inc
PR = "${INC_PR}.2"

SRC_URI += " \
	http://busybox.net/downloads/fixes-1.18.2/busybox-1.18.2-modprobe-small.patch;name=patch01 \
	http://busybox.net/downloads/fixes-1.18.2/busybox-1.18.2-buildsys.patch;name=patch02 \
	http://busybox.net/downloads/fixes-1.18.2/busybox-1.18.2-hush.patch;name=patch03 \
	"

SRC_URI[md5sum] = "69a82091e5710b72db5ce0e14e7c0cd7"
SRC_URI[sha256sum] = "aa7e1cec8cd9c7f4e56098b9e4bb2ab5d593d5a35f766ad9e6a312289bf57080"
SRC_URI[patch01.md5sum] = "dda72eaf33d19d6a0ac78e46e9411cfd"
SRC_URI[patch01.sha256sum] = "ed5d83040414d035138bf484ccd514817342b143baff43ffff6ba556952de7ed"
SRC_URI[patch02.md5sum] = "c7ae920c8adb767fc35b3a8ca3ad7351"
SRC_URI[patch02.sha256sum] = "d9398bc5e65b7eff261f20526b6e07d61bef64dd978c92e6317334bfaa135938"
SRC_URI[patch03.md5sum] = "854045f4b713df759b49945550843acf"
SRC_URI[patch03.sha256sum] = "b70c4406307942f38b2c8d94675b7ca7db8ba0351ae916f838d04856b5aad33f"
