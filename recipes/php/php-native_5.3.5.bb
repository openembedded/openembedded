require php-native.inc

PR = "${INC_PR}.0"

SRC_URI =     "http://downloads.php.net/johannes/php-${PV}.tar.gz;name=src \
               file://acinclude-xml2-config.patch \
               file://php-m4-divert.patch \
              "

SRC_URI[src.md5sum] = "fb727a3ac72bf0ce37e1a20468a7bb81"
SRC_URI[src.sha256sum] = "95474df979efbf2b1a298998fe9954200f59048681817a97eb18415346fb6ca4"
