#!/bin/bash

for machine in collie c7x0 borzoi poodle tosa akita spitz ; 
do
        echo "MACHINE = \"$machine\"" > conf/auto.conf
        echo "MACHINE = \"$machine\""
        
# clean recipes which:
# - emit multiple packages which don't all have the same arch
# - depend on virtual/kernel in some way
        bitbake -c clean matchbox-panel task-bootstrap meta-gpe meta-opie gpe-image \
                   opie-image pivotroot-image sysvinit tslib base-passwd \
                   opie-button-settings zaurus-updater virtual/kernel initscripts \
                   keymaps base-files hostap-modules orinoco-modules \
                   kernel-module-wlags49-h1-cs kernel-module-wlags49-h2-cs

        if [ $machine == "collie" ]; then
            bitbake -c openzaurus-sa collie-kernel-24-8 collie-kernel-32-0 \
                       collie-kernel-32-32 collie-kernel-40-24 collie-kernel-48-16 \
                       collie-kernel-58-6 collie-kernel-64-0
        fi

        if [ $machine == "poodle" ]; then
            bitbake -c openzaurus-pxa poodle-kernel poodle255-kernel poodle-kernels
        fi

        bitbake nano bitbake kernel-module-wlags49-h1-cs kernel-module-wlags49-h2-cs  -k

        if [ $machine == "spitz" ]; then
            bitbake bootstrap-image gpe-image opie-image pivotboot-image e-image e-image-core
		else
            bitbake bootstrap-image gpe-image opie-image e-image e-image-core
        fi
done

echo "MACHINE = \"collie\"" > conf/auto.conf
bitbake meta-sdk

