# Copyright (C) 2007, Stelios Koroneos - Digital OPSiS, All Rights Reserved
# Released under the MIT license (see packages/COPYING)
DESCRIPTION = "grdesktop is a GNOME frontend, for the remote desktop client (rdesktop)."
HOMEPAGE = "http://www.nongnu.org/grdesktop/index.html"
SECTION = "x11/utils"
LICENSE = "GPLv2"

DEPENDS = "gtk+ libgnomeui"
           
RDEPENDS ="rdesktop gail orbit2 gnome-vfs gnome-keyring libbonobo libbonoboui \ 
            libart-lgpl libgnome libidl libglade libgnomecanvas "

PR = "r1"

SRC_URI = "http://download.savannah.nongnu.org/releases/grdesktop/grdesktop-${PV}.tar.gz \
           file://fr.po.patch;patch=1 \
           file://install-help.patch;patch=1"
      

S = "${WORKDIR}/grdesktop-${PV}"

inherit autotools pkgconfig


SRC_URI[md5sum] = "46f8f3e2d4aa2433b8b1537fefa8a4b7"
SRC_URI[sha256sum] = "a94632ed42273d280ad4f8eec6a803024666ed5c8737ae34585c2d9d2eed5193"
