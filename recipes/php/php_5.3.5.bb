require php.inc

PR = "${INC_PR}.0"

SRC_URI += "file://acinclude-xml2-config.patch \
            file://php-m4-divert.patch"

SRC_URI_append_pn-php += "file://iconv.patch \
            file://imap-fix-autofoo.patch \
            file://pear-makefile.patch \
            file://phar-makefile.patch \
            file://php_exec_native.patch \
            "

SRC_URI[md5sum] = "8aaf20c95e91f25c5b6a591e5d6d61b9"
SRC_URI[sha256sum] = "a25ddae6a59d7345bcbb69ef2517784f56c2069af663ae4611e580cbdec77e22"
