class Main {

  private static int MAX_BIKES = 6;

  public static Bicycle inputBicycle(InputUtils input) {
    int cadence = input.getUserInput(
      "Enter the cadence: ",
      new InputUtils.IntegerTransformer(0)
    );
    int startSpeed = input.getUserInput(
      "Enter the speed in MPH: ",
      new InputUtils.IntegerTransformer(0, 60)
    );
    int startGear = input.getUserInput(
      "Enter the gear: ",
      new InputUtils.IntegerTransformer(1, 21)
    );
    String type = input.getUserInput(
      "Enter the type of bike: ",
      new InputUtils.StringTransformer()
    );
    String owner = input.getUserInput(
      "Enter the name of the owner of the bike: ",
      new InputUtils.StringTransformer()
    );

    return new Bicycle(cadence, startSpeed, startGear, type, owner);
  }

  public static void main(String[] args) {
    Bicycle[] bikes = new Bicycle[MAX_BIKES];

    int numberOfBikes = 0;

    try (InputUtils input = new InputUtils()) {
      for (numberOfBikes = 0; numberOfBikes < MAX_BIKES; numberOfBikes++) {
        if (numberOfBikes > 0) {
          if (
            !input.getUserInput(
              "Would you like to add another bike to your collection? ",
              new InputUtils.BooleanTransformer()
            )
          ) break;
        }

        System.out.println("OK, let's add a bicycle:");
        bikes[numberOfBikes] = inputBicycle(input);
      }
    }

    for (int i = 0; i < numberOfBikes; i++) {
      System.out.format("Here is the information for bike #%d:\n", i + 1);
      System.out.println(bikes[i].getInfo());
    }
  }
}
