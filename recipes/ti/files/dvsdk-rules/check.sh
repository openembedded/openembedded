#!/bin/sh

echo "Checking that components in Rules.make are found:"
echo

for x in $CHECKLIST
do
    if [ ! -e $x ]
    then
        echo "WARNING: $x doesn't exist, check your Rules.make.."
    fi
done

echo "Done checking! If no warning messages above, all components are found.."

echo
