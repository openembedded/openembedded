require busybox_1.1x.inc
PR = "${INC_PR}.0"

SRC_URI += " \
	http://busybox.net/downloads/fixes-1.18.3/busybox-1.18.3-buildsys.patch;name=patch01 \
	http://busybox.net/downloads/fixes-1.18.3/busybox-1.18.3-modutils24.patch;name=patch02 \
	http://busybox.net/downloads/fixes-1.18.3/busybox-1.18.3-wget.patch;name=patch03 \
	"

SRC_URI[md5sum] = "660af4d44661d32b22025a66f4f78df2"
SRC_URI[sha256sum] = "83f112ee88b7eb85bea1cac0b1af33f61387a1036f1898c5ecd79813191a619b"
SRC_URI[patch01.md5sum] = "1270a714d2ed9940f04379c97bb83cba"
SRC_URI[patch01.sha256sum] = "cb438f0a5c46125387187b4a2389d56f7aa8db5a308aed314f5866cf9a09b72b"
SRC_URI[patch02.md5sum] = "ce7c3421c87088a7f779278680563bff"
SRC_URI[patch02.sha256sum] = "134ed86867784348f484810464df5bc97589e7aa41079c90e35b8d12b9284df8"
SRC_URI[patch03.md5sum] = "abe065069fed8458eedbdad48c115e1f"
SRC_URI[patch03.sha256sum] = "22538ebee96f66916104b8143cfd16e21568da4c5a89128b9daa60d83a59120b"
