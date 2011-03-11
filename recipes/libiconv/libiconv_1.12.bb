require libiconv.inc
LICENSE = "GPLv3 LGPLv2"

PR = "${INC_PR}.0"

LEAD_SONAME = "libiconv.so"

SRC_URI += "file://autotools.patch \
            file://preload.patch \
           "
do_configure_append () {
        # Fix stupid libtool... handling. 
	# rpath handling can't be disabled and the Makefile's can't be regenerated..
        # (GNU sed required)
        sed -i s/^hardcode_libdir_flag_spec/#hardcode_libdir_flag_spec/ ${S}/*-libtool
}

SRC_URI[md5sum] = "c2be282595751535a618ae0edeb8f648"
SRC_URI[sha256sum] = "a99e244fd78babb95ea3c9a5c88b964994edaa1d15fd8dde5b4067801e23f0cd"
