require busybox_1.1x.inc
PR = "${INC_PR}.4"

SRC_URI += " \
	http://busybox.net/downloads/fixes-1.18.2/busybox-1.18.2-modprobe-small.patch;name=patch01 \
	http://busybox.net/downloads/fixes-1.18.2/busybox-1.18.2-buildsys.patch;name=patch02 \
	http://busybox.net/downloads/fixes-1.18.2/busybox-1.18.2-hush.patch;name=patch03 \
	http://busybox.net/downloads/fixes-1.18.2/busybox-1.18.2-wc.patch;name=patch04 \
	http://busybox.net/downloads/fixes-1.18.2/busybox-1.18.2-libbb.patch;name=patch05 \
	http://busybox.net/downloads/fixes-1.18.2/busybox-1.18.2-modprobe.patch;name=patch06 \
	"

SRC_URI[md5sum] = "69a82091e5710b72db5ce0e14e7c0cd7"
SRC_URI[sha256sum] = "aa7e1cec8cd9c7f4e56098b9e4bb2ab5d593d5a35f766ad9e6a312289bf57080"
SRC_URI[patch01.md5sum] = "dda72eaf33d19d6a0ac78e46e9411cfd"
SRC_URI[patch01.sha256sum] = "ed5d83040414d035138bf484ccd514817342b143baff43ffff6ba556952de7ed"
SRC_URI[patch02.md5sum] = "c7ae920c8adb767fc35b3a8ca3ad7351"
SRC_URI[patch02.sha256sum] = "d9398bc5e65b7eff261f20526b6e07d61bef64dd978c92e6317334bfaa135938"
SRC_URI[patch03.md5sum] = "854045f4b713df759b49945550843acf"
SRC_URI[patch03.sha256sum] = "b70c4406307942f38b2c8d94675b7ca7db8ba0351ae916f838d04856b5aad33f"
SRC_URI[patch04.md5sum] = "4414f080287c22c9bbc42d1d70f488d4"
SRC_URI[patch04.sha256sum] = "e2abd861538b586ef4a3439b68a2ef41db99b65e4a37c7442ffc8edfe67ae549"
SRC_URI[patch05.md5sum] = "354b36a75808e3a477d48d1c582d2265"
SRC_URI[patch05.sha256sum] = "71e3e1884869e2ee84714874f4792574ae905e83a64b3508c6c16d6661909401"
SRC_URI[patch06.md5sum] = "bd525ff4850e104a8571bad57b299fc3"
SRC_URI[patch06.sha256sum] = "624dd02e1cf76dc755e8b9fd1a18f0bb579976793a07e632b0dba061d0d4b79d"
