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
	mv ${D}/etc/elvis/elvis.clr ${D}/etc/elvis/elvis.clr-orig
}

PACKAGES = "${PN}"
FILES_${PN} = "/usr/bin/elvis /etc/elvis"
