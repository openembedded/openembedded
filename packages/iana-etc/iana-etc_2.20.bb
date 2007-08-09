DESCRIPTION = "The iana-etc package provides the Unix/Linux /etc/services and /etc/protocols files."
AUTHOR = "Seth W. Klein"
HOMEPAGE = "http://www.sethwklein.net/projects/iana-etc/"
SECTION = "base"
LICENSE = "OPL"

SRC_URI = "http://www.sethwklein.net/projects/iana-etc/downloads/${P}.tar.bz2"

do_make(){
        oe_runmake 'STRIP=yes'
}

do_install(){
        oe_runmake 'DESTDIR=${D}' install
}
