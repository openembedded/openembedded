require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_noncore_styles_theme.tar.bz2;name=split_noncore_styles_theme \
	http://sources.openembedded.org/opie-1.2.4-split_plugins_styles.tar.bz2;name=split_plugins_styles"
SRC_URI[split_noncore_styles_theme.md5sum] = "18ef3df6c95b6fff9ca63256310fb290"
SRC_URI[split_noncore_styles_theme.sha256sum] = "0647bc50c9a50aa247050975cf9345493419d17c6f0c2198099e487a443fa0e4"
SRC_URI[split_plugins_styles.md5sum] = "5200474f10033be0e64d04ebc42abfb6"
SRC_URI[split_plugins_styles.sha256sum] = "e78d9ac7f1aa83903ff3d871c2588f0b18b3851be45fae41350daf264c7e12a4"
