require dietlibc.inc

PR = "${INC_PR}.2"

SRC_URI += "file://ccache.patch;patch=1 \
            file://ceil.patch;patch=1 \
            file://diethome.patch;patch=1 \
            file://getrlimit.patch;patch=1 \
           " 


SRC_URI[md5sum] = "0098761c17924c15e21d25acdda4a8b5"
SRC_URI[sha256sum] = "6613a2cae3b39e340779735d7500d284f5a691c5ed67e59a6057e0888726e458"
