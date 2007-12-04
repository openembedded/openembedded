#!/bin/bash

# No graphics
for i in ep93xx ixp4xxle ixp4xxbe gumstix-connex efika 
        do
          echo "MACHINE = \"$i\"" > conf/auto.conf
      	  bitbake minimal-image ; bitbake console-image
        done

for i in ixp4xxle ixp4xxbe 
       do
         echo "MACHINE = \"$i\"" > conf/auto.conf
         bitbake nslu2-minimal-image
       done	 

# build altboot images for zaurus
for i in c7x0 poodle tosa akita spitz collie
        do
	  echo "MACHINE = \"$i\"" > conf/auto.conf
	  bitbake altboot-console-image
#	  echo ANGSTROM_MODE = \"uclibc\" >> conf/auto.conf
#	  bitbake altboot-console-image
	done  

# graphics, flash storage
for i in fic-gta01 a780 at91sam9263ek qemuarm h2200 h4000 omap5912osk poodle tosa hx4700 c7x0 spitz akita collie 
        do
	  echo "MACHINE = \"$i\"" > conf/auto.conf
	  bitbake minimal-image ; bitbake console-image ; bitbake x11-image 
        done

# graphics, disk storage	
for i in spitz 
       do
         echo "MACHINE = \"$i\"" > conf/auto.conf
	 bitbake -c clean qmake2-native ; bitbake x11-gpe-image ; bitbake x11-pimlico-image ; bitbake x11-office-image
#         echo ANGSTROM_MODE = \"uclibc\" >> conf/auto.conf
#	 bitbake x11-gpe-mage ; bitbake x11-pimlico-image ; bitbake x11-office-image
       done 


#phones
for i in fic-gta01 a780 
        do
         echo "MACHINE = \"$i\"" > conf/auto.conf
	 bitbake -c clean qmake2-native ;bitbake openmoko-image
#	 echo ANGSTROM_MODE = \"uclibc\" >> conf/auto.conf
#	 bitbake openmoko-image
       done	 

