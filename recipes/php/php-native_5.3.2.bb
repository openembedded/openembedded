require php-native.inc

PR = "${INC_PR}.1"

SRC_URI =     "http://museum.php.net/php5/php-${PV}.tar.bz2;name=src \
               file://acinclude-xml2-config.patch \
               file://php-m4-divert.patch \
	       file://CVE-2010-0397.patch"

SRC_URI[src.md5sum] = "46f500816125202c48a458d0133254a4"
SRC_URI[src.sha256sum] = "9a380a574adcb3a9abe3226e7c3a9bae619e8a1b90842ec2a7edf0ad92afdeda"

