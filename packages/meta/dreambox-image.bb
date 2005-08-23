export IMAGE_BASENAME = "dreambox-image"

OPENDREAMBOX_COMMON = "base-files busybox \
	ipkg initscripts sysvinit netbase dropbear tinylogin \
	base-passwd enigma ncurses joe mc tuxbox-common vsftpd timezones-alternative \
	netkit-base fakelocale less dreambox-bootlogo  dreambox-dvb-tools \
	dreambox-dccamd tuxbox-stream dreambox-keymaps tuxbox-image-info dvbsnoop \
	ipkgpl dreamdata \
	dreambox-compat"

OPENDREAMBOX_COMMON_D = "util-linux e2fsprogs tuxbox-plugins links-dream enigma-modem \
			ppp module-init-tools modutils-initscripts samba"
OPENDREAMBOX_COMMON_R = "util-linux-sfdisk util-linux-fdisk e2fsprogs-mke2fs e2fsprogs-e2fsck \
	tuxbox-plugin-snake     tuxbox-plugin-tuxmail \
	tuxbox-plugin-lcdcirc   tuxbox-plugin-soko      tuxbox-plugin-tuxtxt \
	tuxbox-plugin-sol       tuxbox-plugin-vierg  	tuxbox-plugin-master \
	tuxbox-plugin-solitair  tuxbox-plugin-yahtzee 	tuxbox-plugin-mines  \
	tuxbox-plugin-tank  	tuxbox-plugin-pacman    tuxbox-plugin-tetris \
	tuxbox-plugin-satfind   tuxbox-plugin-tuxcom 	links-dream-plugin \
	kernel-module-slhc 	kernel-module-ppp-async kernel-module-crc-ccitt \
	ppp			kernel-module-ppp-generic \
	update-modules		enigma-modem 		module-init-tools-depmod \
	modutils-initscripts	sambaserver"

#enigma-locale-ar enigma-locale-sr enigma-locale-ur
ENIGMA_LANGUAGE = "enigma-locale-cs enigma-locale-da \
	enigma-locale-de enigma-locale-el enigma-locale-es enigma-locale-et \
	enigma-locale-fi enigma-locale-fr enigma-locale-hr enigma-locale-hu \
	enigma-locale-is enigma-locale-it enigma-locale-lt enigma-locale-nl \
	enigma-locale-no enigma-locale-pl enigma-locale-pt enigma-locale-ro \
	enigma-locale-ru enigma-locale-sk enigma-locale-sl \
	enigma-locale-sv enigma-locale-tr"

DEPENDS = "${OPENDREAMBOX_COMMON} ${BOOTSTRAP_EXTRA_DEPENDS} ${OPENDREAMBOX_COMMON_D}"
RDEPENDS = "ncurses-terminfo ${OPENDREAMBOX_COMMON} ${BOOTSTRAP_EXTRA_RDEPENDS} ${OPENDREAMBOX_COMMON_R} ${ENIGMA_LANGUAGE}"

# we don't want any locales
IMAGE_LINGUAS = " "

export IPKG_INSTALL = '${RDEPENDS}'

inherit image_ipk
