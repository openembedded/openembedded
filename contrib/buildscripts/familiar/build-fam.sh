#!/bin/bash
#Buildscript to build familiar images (c) Koen Kooi 2006
#Execute this script in the directory containing your local conf/ directory

#jornada56x and jornada7xx don't build
for i in h3600 h3900 h2200 h6300 ipaq-pxa270 simpad ; do
         echo "MACHINE = \"$i\"" > conf/auto.conf
	bitbake nano fuse fuse-module bitbake kernel-module-wlags49-h1-cs kernel-module-wlags49-h2-cs  -k
        echo "bitbaking $i"
	#clean .bbs which emit multiple packages which don't all have the same arch
         bitbake -c clean matchbox-panel task-bootstrap meta-gpe meta-opie gpe-image opie-image sysvinit tslib base-passwd prism3-support opie-button-settings
        bitbake  bootstrap-image ; bitbake gpe-image ; bitbake opie-image ; done

