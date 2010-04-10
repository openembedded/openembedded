DESCRIPTION = "GGZ Gaming Zone lib" 
LICENSE = "LGPLv2"
DEPENDS = "gnutls libgcrypt" 

SRC_URI = "http://ftp.belnet.be/packages/ggzgamingzone/ggz/${PV}/${PN}-${PV}.tar.gz"

inherit autotools

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage() {
        autotools_stage_all
}



SRC_URI[md5sum] = "603739504648833779aa13b0327a1c3d"
SRC_URI[sha256sum] = "54301052a327f2ff3f2d684c5b1d7920e8601e13f4f8d5f1d170e5a7c9585e85"
