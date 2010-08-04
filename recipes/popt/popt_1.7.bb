require popt.inc

PR = "${INC_PR}.0"

SRC_URI = "\
  http://rpm.org/releases/historical/rpm-4.1.x/popt-${PV}.tar.gz \
  file://m4.patch \
  file://intl.patch \
  file://mkinstalldirs.patch \
"

do_configure() {
       gnu-configize
       aclocal
       libtoolize --copy --force
       automake --add-missing
       autoreconf
       oe_runconf
}

BBCLASSEXTEND = "native"

SRC_URI[md5sum] = "5988e7aeb0ae4dac8d83561265984cc9"
SRC_URI[sha256sum] = "4e75cb28793f0d44134f71fae53057d5f250805e6268fbd9c9780654b73b0dc1"
