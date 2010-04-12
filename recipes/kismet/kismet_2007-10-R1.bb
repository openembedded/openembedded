require kismet.inc

SRC_URI += "file://fix_strip.patch;patch=1 \
            file://string_h.patch;patch=1"

PR = "r5"

SRC_URI[md5sum] = "2100c667e69db0cde35fa2d06c8516e2"
SRC_URI[sha256sum] = "023e7f47039c1ad8615052e464f76a3cd496a423449b931036d127c56d58b2b9"
