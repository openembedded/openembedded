# Copyright (C) 2007, Stelios Koroneos - Digital OPSiS, All Rights Reserved
# Released under the MIT license (see packages/COPYING)

require debianutils.inc
PR="r1"

do_configure_prepend() {
	sed -i -e 's:tempfile.1 which.1:which.1:g' Makefile.am
}
