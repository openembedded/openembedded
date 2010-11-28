require ${PN}.inc

PR = "r2"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_noncore_settings_networksettings.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.4-split_apps.tar.bz2 \
           http://sources.openembedded.org/opie-1.2.4-split_root.tar.bz2 \
	   file://wireless.patch \
          "
