# grt-storage-starter-code

![sensor setup:](https://media.discordapp.net/attachments/779501548493471754/801845285969330216/IMG-3363.JPG?width=473&height=630)

this code controls the storage mechanism with two IR sensors.
cases:
1 cell. the bottom sensor will be triggered and it will turn the motor until it in not in 'view' anymore, or when it is in the upward shaft. this will not create a gap because it will stop if it does not see the cell at all, which is when it has just passed through.
2 cells. the bottom sensor will be triggered again and both cells will be pushed into the shaft, upwards.
3 cells. the same will happen. if the cells reach the top, they will trigger the top sensor and the motor will stop turning.
4+ cells. they will pile in front of the tubing, as the top sensor is triggered still and it will not move. only 5 cells will fit.

the method updates very often so there should be no issues with that. if nothing interferes with the mechanism, then it will work.
