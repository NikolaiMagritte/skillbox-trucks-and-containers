public class Cargo {
    public static final int BOXES_PER_CONTAINER = 27;
    public static final int CONTAINERS_PER_TRUCK = 12;
    private int containerCount;
    private int trucksCount;
    private int boxCount;

    public Cargo(int boxCount) {
        this.boxCount = boxCount;
        calculateContainersAndTrucksCount();
    }

    private void calculateContainersAndTrucksCount() {
        containerCount = boxCount / BOXES_PER_CONTAINER + (boxCount % BOXES_PER_CONTAINER == 0 ? 0: 1);
        trucksCount = containerCount / CONTAINERS_PER_TRUCK +
                (containerCount % CONTAINERS_PER_TRUCK == 0 ? 0 : 1);
    }
    public void containersAndTrucksCountMessage() {
        System.out.println("Необходимо:" + "\n"
                + "грузовиков - " + trucksCount + " шт." + "\n"
                + "контейнеров - " + containerCount + " шт.");
    }

    public void containerDistributionMessage() {
        int boxIndex = 1;
        int containerIndex = 1;
        for (int truckIndex = 1;  truckIndex <= trucksCount; truckIndex++) {
            System.out.println("Грузовик: " + truckIndex);
            int containersInThisTruck = 1;
            while (containerIndex <= containerCount && containersInThisTruck <= CONTAINERS_PER_TRUCK) {
                System.out.println("\tКонтейнер: " + containerIndex);
                int boxesInThisContainer = 1;
                while (boxIndex <= boxCount && boxesInThisContainer <= BOXES_PER_CONTAINER) {
                    System.out.println("\t\tЯщик: " + boxIndex);
                    boxesInThisContainer++;
                    boxIndex++;
                }
                containerIndex++;
                containersInThisTruck++;
            }
        }

        /*
        Вариант реализации распределения ящиков по контейнерам, а контейнеров по грузовикам
        без использования вложенных циклов:
        int truckIndex = 1;
        int containerIndex = 1;
        int boxes = 0;

        while (boxes < boxCount) {
            System.out.println("\t\tЯщик: " + ++boxes);
            if ((containerIndex % CONTAINERS_PER_TRUCK == 0)
                    && (boxes % BOXES_PER_CONTAINER == 0)) {
                System.out.println("Грузовик: " + ++truckIndex);
            }
            if (boxes % BOXES_PER_CONTAINER == 0) {
                System.out.println("\tКонтейнер: " + ++containerIndex);
            }
        }
         */
    }
}
