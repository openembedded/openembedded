require file.inc

PR = "${INCPR}.0"

SRC_URI = "ftp://ftp.astron.com/pub/file/file-${PV}.tar.gz \
           file://dump \
           file://filesystems"

SRC_URI_append_virtclass-native = " file://native-fix.diff;patch=1"

do_configure_prepend() {
	sed -i -e 's,$(top_builddir)/src/file,file,' ${S}/magic/Makefile.am
	cp ${WORKDIR}/dump ${S}/magic/Magdir/
	cp ${WORKDIR}/filesystems ${S}/magic/Magdir/
}

SRC_URI[md5sum] = "ce1aa9b0316feb57d40a48cfe6b606e4"
SRC_URI[sha256sum] = "5090d5123ea642842d04d3f93a821e1372e5d9e434c74c08ee2483cc150a6273"
