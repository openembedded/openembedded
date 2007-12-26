#!/bin/bash

DO_UCLIBC=0

do_build() {
	echo "MACHINE = \"$BUILD_MACHINE\"" > conf/auto.conf

	BUILD_MODE="glibc"
	if [ "$BUILD_CLEAN" != "" ]
	then
		bitbake -c clean $BUILD_CLEAN
	fi

	for target in $BUILD_TARGETS
	do
		bitbake $target && do_report_success
	done

	if [ $DO_UCLIBC = 1 ]
	then
		BUILD_MODE="uclibc"
		echo 'ANGSTROM_MODE = "uclibc"' >> conf/auto.conf
		for target in $BUILD_TARGETS
		do
			bitbake $target && do_report_success
		done
	fi
}

do_report_success() {

	echo "$(date -u +%s) $target $BUILD_MODE $machine" >> autobuilder.log
}

#cross toolchain
#for machine in ep93xx a780 efika collie ixp4xxbe
#do
#        BUILD_MACHINE=$machine
#        BUILD_TARGETS="meta-toolchain"
#       BUILD_CLEAN="meta-toolchain"
#        do_build
#done


# No graphics
for machine in ep93xx gumstix-connex gumstix-verdex efika omap5912osk
do
	BUILD_MACHINE=$machine
	BUILD_CLEAN="libtool-cross base-files"
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

# build altboot images for zaurus
for machine in c7x0 poodle tosa akita spitz collie
do
	BUILD_CLEAN="base-files"
	BUILD_MACHINE=$machine
	BUILD_TARGETS="altboot-console-image"
	do_build
done  

# graphics, flash storage
for machine in fic-gta01 a780 at91sam9263ek qemuarm h2200 h3900 h4000 h5000 poodle tosa hx4700 c7x0 spitz akita collie simpad 
do
	BUILD_CLEAN="base-files"
	BUILD_MACHINE=$machine
	BUILD_TARGETS="base-image console-image minimal-gpe-image x11-image"
	do_build
done

# graphics, disk storage	
for machine in spitz 
do
	BUILD_CLEAN="base-files"
	BUILD_MACHINE=$machine
	BUILD_TARGETS="x11-gpe-image x11-pimlico-image x11-office-image"
	do_build
done 

#phones
for machine in fic-gta01 a780 
do
	BUILD_MACHINE=$machine
	BUILD_TARGETS="minimal-openmoko-image openmoko-image"
	do_build
done	

# populate feeds
#for machine in ep93xx a780 efika collie ixp4xxbe
#do
#        BUILD_MACHINE=$machine
#        BUILD_TARGETS="meta-angstrom-2007"
#	do_build
#done

