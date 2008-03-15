require rsync.inc

DEPENDS += "popt"

PR = "r0"

SRC_URI = "http://rsync.samba.org/ftp/rsync/rsync-${PV}.tar.gz \
           file://m4.patch;patch=1 \
           file://rsyncd.conf"

do_compile_prepend() {
        sed -i "s/conf_stop make_stop//" Makefile
}
