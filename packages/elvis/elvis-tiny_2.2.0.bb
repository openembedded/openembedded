require elvis_${PV}.bb

do_configure_append() {
	for i in DISPLAY_MAN DISPLAY_HTML DISPLAY_TEX \
			PROTOCOL_HTTP PROTOCOL_FTP FEATURE_ARRAY \
			FEATURE_BROWSE FEATURE_FOLD FEATURE_INCSEARCH \
			FEATURE_LPR FEATURE_MAKE FEATURE_MAPDB \
			FEATURE_MKEXRC FEATURE_RCSID FEATURE_SHOWTAG \
			FEATURE_SPELL FEATURE_TEXTOBJ; do
		sed -i -e "s/^#define[	 ]*${i}/#undef ${i}/g" config.h
	done
}

do_install_append() {
	sed -i -e "s/^source\(.* .*elvis.clr.*\)/\"source\1/" ${D}/etc/elvis/elvis.ini
	sed -i -e "s/^set\(.*lptype.*\)/\"set\1/" ${D}/etc/elvis/elvis.ini
}

PACKAGES = "${PN}"
FILES_${PN} = "/usr/bin/elvis /etc/elvis"
