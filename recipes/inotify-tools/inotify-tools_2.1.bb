DESCRIPTION = "inotify-tools is a set of command line utilities for the \
Linux inotify filesystem change notification system."
LICENSE = "GPL"
AUTHOR = "Rohan McGovern"
HOMEPAGE = "http://rohanpm.net/inotify-tools"
PR = "r0"

SRC_URI = "http://rohanpm.net/files/inotify-tools-2.1.tar.gz"

inherit autotools


SRC_URI[md5sum] = "8053f441fc3fe0f0c73cf483399da17b"
SRC_URI[sha256sum] = "84a111a6a979152cd25b60825b4945da4b167f19fb9ec115f9c59b4b49927547"
