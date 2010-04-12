SRC_URI = "http://64.34.161.181/download/1.5.0/sources/${P}.tar.gz"
inherit autotools
S = "${WORKDIR}/${PN}"

SRC_URI[md5sum] = "cbfb081fbc4b7fe52f723ab503c328ca"
SRC_URI[sha256sum] = "cf1d47b027d47d151782e93cf67fa6177da5cbe9aded27ab116240d56527c2ba"
