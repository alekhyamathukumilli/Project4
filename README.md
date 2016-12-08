# CPU Scheduling Algorithms RR and MLFQ
This project is regarding comparision between the two CPU scheduling algorithms Round Robin and Multi Level Feedback Queue with respect to turnaround time

The fundamental problem MLFQ tries to address is two-fold. First, it
would like to optimize turnaround time, which may be obtained by running shorter jobs first;
unfortunately, the OS doesn’t generally know how long a job will run for, exactly the knowledge that
algorithms like SJF (or STCF) require. Second, MLFQ would like to make
a system feel responsive to interactive users (i.e., users sitting and staring
at the screen, waiting for a process to finish), and thus minimize response
time; Round Robin algorithm would reduce response time
but are terrible for turnaround time

According to the priority boost back time, the average turn around time is always better in MLFQ

Outputs(are in the file outputs.txt) for all the given inputs(are in the file input.txt) are compared and shown in the graphs attached.

Instructions:
- Download the project
- Copy the inputs from input txt file
- Add them to the main method of CPUScheduler class 
- Run
- Output is generated
