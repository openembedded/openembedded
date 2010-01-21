DESCRIPTION = "Common icons for GPE"
LICENSE = "GPL"

PR = "${INC_PR}.0"

inherit gpe

FILES_${PN} = "${datadir}/gpe"

#Only SHR is using u-a for gpe-icons
do_configure_prepend_shr() {
        sed -i "s| \$(DESTDIR)\$(PREFIX)/share/gpe/pixmaps/| \$(DESTDIR)\$(PREFIX)/share/gpe/pixmaps.${PN}/|g" Makefile
}

require gpe-icons.inc
