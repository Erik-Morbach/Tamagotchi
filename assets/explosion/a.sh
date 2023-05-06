#!/bin/bash
for i in {1..62}
do
    asciify txt "explosionF$i.png" 50 20 > "explosionF$i.txt"
done
