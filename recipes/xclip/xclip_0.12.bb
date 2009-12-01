DECSRIPTION = "xclip is a command line interface to the X11 clipboard. It can also be used for copying files, as an alternative to sftp/scp, thus avoiding password prompts when X11 forwarding has already been setup."
LICENSE = "GPLv2"

DEPENDS = "libxmu virtual/libx11 "

SRC_URI = "${SOURCEFORGE_MIRROR}/xclip/${P}.tar.gz"

inherit autotools


