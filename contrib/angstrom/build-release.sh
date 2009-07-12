#!/bin/bash

DO_UCLIBC=0

do_build() {
        if [ $DO_UCLIBC = 1 ]
        then
                BUILD_MODE="uclibc"
                echo 'ANGSTROMLIBC = "uclibc"' > conf/auto.conf

                if [ "$BUILD_CLEAN" != "" ]
                then
                        MACHINE=$BUILD_MACHINE bitbake -c clean $BUILD_CLEAN
                fi

                for target in $BUILD_TARGETS
                do
                        MACHINE=$BUILD_MACHINE bitbake $target && do_report_success
                done
        fi

	BUILD_MODE="glibc"
        echo 'ANGSTROMLIBC = "glibc"' > conf/auto.conf

	if [ "$BUILD_CLEAN" != "" ]
	then
		MACHINE=$BUILD_MACHINE bitbake -c clean $BUILD_CLEAN
	fi

	for target in $BUILD_TARGETS
	do
		MACHINE=$BUILD_MACHINE bitbake $target && do_report_success
	done
}

do_report_success() {

	echo "$(date -u +%s) $target $BUILD_MODE $machine" >> autobuilder.log
}

#cross toolchain
# Architectures:
# * arm-oabi:  simpad
# * armv4t:    om-gta01
# * armv5te:   c7x0
# * armv6:     nokia800
# * armv6-novfp: htckaiser
# * armv7a:    beagleboard
# * ppc405:    dht-walnut
# * ppc603e:   efika
# * i586:      qemux86

for machine in simpad om-gta01 c7x0 nokia800 htckaiser beagleboard dht-walnut efika qemux86
do
        BUILD_MACHINE=$machine
        BUILD_TARGETS="meta-toolchain"
        BUILD_CLEAN="meta-toolchain"
        do_build
done


# No graphics
for machine in dns323 mv2120 kuropro lspro tsx09 ts409 gumstix-connex gumstix-verdex efika dht-walnut omap5912osk afeb9260 at91sam9g20ek
do
	BUILD_MACHINE=$machine
	BUILD_CLEAN="base-files"
	BUILD_TARGETS="base-image console-image"
	do_build
done

for machine in ixp4xxle ixp4xxbe 
do
	BUILD_CLEAN="base-files"
	BUILD_MACHINE=$machine
	BUILD_TARGETS="base-image nslu2-base-image nas-server-image"
	do_build
done	 

# build kexecboot kernels for supported machines
for machine in h2200 hx4700 c7x0 akita spitz poodle collie tosa
do
	BUILD_MACHINE=$machine
	BUILD_TARGETS="linux-kexecboot"
	do_build
done 


# graphics, flash storage
for machine in overo omap3-pandora beagleboard omap3evm om-gta01 om-gta02 a780 at91sam9263ek qemuarm qemux86 h2200 h3900 h4000 h5000 poodle tosa hx4700 c7x0 spitz akita collie simpad palmz72
do
	BUILD_CLEAN="base-files"
	BUILD_MACHINE=$machine
	BUILD_TARGETS="initramfs-bootmenu-image base-image console-image minimal-gpe-image x11-image"
	do_build
done

# graphics, disk storage	
for machine in spitz overo omap3-pandora beagleboard omap3evm 
do
	BUILD_CLEAN="base-files"
	BUILD_MACHINE=$machine
	BUILD_TARGETS="x11-gpe-image x11-pimlico-image x11-office-image"
	do_build
done 

#phones
for machine in om-gta01 om-gta02 a780  
do
	BUILD_MACHINE=$machine
	BUILD_TARGETS="minimal-openmoko-image openmoko-image fso-console-image fso-illume-image fso-image-light fso-image-nox fso-image"
	do_build
done	

# omap3 boards
for machine in overo omap3-pandora beagleboard omap3evm
do
	BUILD_MACHINE=$machine
	BUILD_TARGETS="beagleboard-demo-image"
	do_build
done

# Opie
for machine in h2200 h3900 h4000 h5000 hx4700 htcuniversal akita c7x0 collie poodle spitz tosa simpad palmz72
do
        BUILD_CLEAN="base-files"
        BUILD_MACHINE=$machine
        BUILD_TARGETS="opie-image"
        do_build
done

