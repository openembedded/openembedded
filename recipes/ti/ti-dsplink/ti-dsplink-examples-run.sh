#! /bin/sh

echo "Running Loop Sample App"
./loopgpp loop.out 1024 2000 0

echo "Running Message Sample App"
./messagegpp message.out 10000 0

echo "Running Message Multi Sample App"
./messagemultigpp messagemulti.out 128 1 0

echo "Running MultiProcessor List Sample App"
./mplistgpp mplist.out 128 128 0

echo "Running MultiProcessorCriticalSection Transfer Sample App" 
./mpcsxfergpp mpcsxfer.out 128 1000 0

echo "Running Ringio Sample App"
./ringiogpp ringio.out 2048 128 0

echo "Running Scale Sample App"
./scalegpp scale.out 128 500 0

#echo "Running Read/Write Sample App"
#./readwritegpp readwrite.out 
